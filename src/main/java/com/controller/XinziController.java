
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 薪资
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinzi")
public class XinziController {
    private static final Logger logger = LoggerFactory.getLogger(XinziController.class);

    private static final String TABLE_NAME = "xinzi";

    @Autowired
    private XinziService xinziService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private GongsiService gongsiService;//用工部门
    @Autowired
    private MianshijiluService mianshijiluService;//面试记录
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private YonghuService yonghuService;//学生
    @Autowired
    private ZhaopinService zhaopinService;//职位招聘
    @Autowired
    private ZhaopinCollectionService zhaopinCollectionService;//职位收藏
    @Autowired
    private ZhaopinLiuyanService zhaopinLiuyanService;//职位留言
    @Autowired
    private ZhaopinYuyueService zhaopinYuyueService;//兼职报名
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("用工部门".equals(role))
            params.put("gongsiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = xinziService.queryPage(params);

        //字典表数据转换
        List<XinziView> list =(List<XinziView>)page.getList();
        for(XinziView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinziEntity xinzi = xinziService.selectById(id);
        if(xinzi !=null){
            //entity转view
            XinziView view = new XinziView();
            BeanUtils.copyProperties( xinzi , view );//把实体数据重构到view中
            //级联表 用工部门
            //级联表
            GongsiEntity gongsi = gongsiService.selectById(xinzi.getGongsiId());
            if(gongsi != null){
            BeanUtils.copyProperties( gongsi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "gongsiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setGongsiId(gongsi.getId());
            }
            //级联表 学生
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xinzi.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "gongsiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XinziEntity xinzi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinzi:{}",this.getClass().getName(),xinzi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xinzi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("用工部门".equals(role))
            xinzi.setGongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XinziEntity> queryWrapper = new EntityWrapper<XinziEntity>()
            .eq("gongsi_id", xinzi.getGongsiId())
            .eq("yonghu_id", xinzi.getYonghuId())
            .eq("xinzi_month", xinzi.getXinziMonth())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinziEntity xinziEntity = xinziService.selectOne(queryWrapper);
        if(xinziEntity==null){
            xinzi.setInsertTime(new Date());
            xinzi.setCreateTime(new Date());
            xinzi.setShifaJine(xinzi.getJixiaoJine()+xinzi.getJiangjinJine()+xinzi.getButieJine()+xinzi.getJibenJine());//薪资表特有,不需要可以手动删掉
            xinziService.insert(xinzi);
            return R.ok();
        }else {
            return R.error(511,"该部门给该学生开具了该月份的工资,不能重复开具");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinziEntity xinzi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xinzi:{}",this.getClass().getName(),xinzi.toString());
        XinziEntity oldXinziEntity = xinziService.selectById(xinzi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xinzi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("用工部门".equals(role))
//            xinzi.setGongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(xinzi.getXinziContent()) || "null".equals(xinzi.getXinziContent())){
                xinzi.setXinziContent(null);
        }
        xinzi.setShifaJine(xinzi.getJixiaoJine()+xinzi.getJiangjinJine()+xinzi.getButieJine()+xinzi.getJibenJine());//薪资表特有,不需要可以手动删掉

            xinziService.updateById(xinzi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XinziEntity> oldXinziList =xinziService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xinziService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<XinziEntity> xinziList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XinziEntity xinziEntity = new XinziEntity();
//                            xinziEntity.setGongsiId(Integer.valueOf(data.get(0)));   //用工部门 要改的
//                            xinziEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xinziEntity.setXinziUuidNumber(data.get(0));                    //薪资编号 要改的
//                            xinziEntity.setXinziMonth(data.get(0));                    //月份 要改的
//                            xinziEntity.setJibenJine(data.get(0));                    //基本工资 要改的
//                            xinziEntity.setJiangjinJine(data.get(0));                    //奖金 要改的
//                            xinziEntity.setJixiaoJine(data.get(0));                    //绩效 要改的
//                            xinziEntity.setButieJine(data.get(0));                    //补贴 要改的
//                            xinziEntity.setShifaJine(data.get(0));                    //实发 要改的
//                            xinziEntity.setXinziContent("");//详情和图片
//                            xinziEntity.setInsertTime(date);//时间
//                            xinziEntity.setCreateTime(date);//时间
                            xinziList.add(xinziEntity);


                            //把要查询是否重复的字段放入map中
                                //薪资编号
                                if(seachFields.containsKey("xinziUuidNumber")){
                                    List<String> xinziUuidNumber = seachFields.get("xinziUuidNumber");
                                    xinziUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xinziUuidNumber = new ArrayList<>();
                                    xinziUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xinziUuidNumber",xinziUuidNumber);
                                }
                        }

                        //查询是否重复
                         //薪资编号
                        List<XinziEntity> xinziEntities_xinziUuidNumber = xinziService.selectList(new EntityWrapper<XinziEntity>().in("xinzi_uuid_number", seachFields.get("xinziUuidNumber")));
                        if(xinziEntities_xinziUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XinziEntity s:xinziEntities_xinziUuidNumber){
                                repeatFields.add(s.getXinziUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [薪资编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xinziService.insertBatch(xinziList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xinziService.queryPage(params);

        //字典表数据转换
        List<XinziView> list =(List<XinziView>)page.getList();
        for(XinziView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinziEntity xinzi = xinziService.selectById(id);
            if(xinzi !=null){


                //entity转view
                XinziView view = new XinziView();
                BeanUtils.copyProperties( xinzi , view );//把实体数据重构到view中

                //级联表
                    GongsiEntity gongsi = gongsiService.selectById(xinzi.getGongsiId());
                if(gongsi != null){
                    BeanUtils.copyProperties( gongsi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "gongsiId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGongsiId(gongsi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xinzi.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "gongsiId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XinziEntity xinzi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xinzi:{}",this.getClass().getName(),xinzi.toString());
        Wrapper<XinziEntity> queryWrapper = new EntityWrapper<XinziEntity>()
            .eq("gongsi_id", xinzi.getGongsiId())
            .eq("yonghu_id", xinzi.getYonghuId())
            .eq("xinzi_uuid_number", xinzi.getXinziUuidNumber())
            .eq("xinzi_month", xinzi.getXinziMonth())
//            .notIn("xinzi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinziEntity xinziEntity = xinziService.selectOne(queryWrapper);
        if(xinziEntity==null){
            xinzi.setInsertTime(new Date());
            xinzi.setCreateTime(new Date());
        xinziService.insert(xinzi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

