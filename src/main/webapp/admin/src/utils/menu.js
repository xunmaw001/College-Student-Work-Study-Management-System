const menu = {
    list() {
        return [
    {
        "backMenu":[
            {
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"管理员管理",
                        "menuJump":"列表",
                        "tableName":"users"
                    }
                ],
                "menu":"管理员管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"用工部门类型",
                        "menuJump":"列表",
                        "tableName":"dictionaryGongsi"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"公告信息类型",
                        "menuJump":"列表",
                        "tableName":"dictionaryNews"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"招聘岗位管理",
                        "menuJump":"列表",
                        "tableName":"dictionaryZhaopin"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"院系管理",
                        "menuJump":"列表",
                        "tableName":"dictionaryYuanxi"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"专业管理",
                        "menuJump":"列表",
                        "tableName":"dictionaryZhuanye"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"年级管理",
                        "menuJump":"列表",
                        "tableName":"dictionaryNianji"
                    }
                ],
                "menu":"基础数据管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"公告信息管理",
                        "menuJump":"列表",
                        "tableName":"news"
                    }
                ],
                "menu":"公告信息管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"薪资管理",
                        "menuJump":"列表",
                        "tableName":"xinzi"
                    }
                ],
                "menu":"薪资管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"职位招聘管理",
                        "menuJump":"列表",
                        "tableName":"zhaopin"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "修改",
                            "删除"
                        ],
                        "menu":"职位留言管理",
                        "menuJump":"列表",
                        "tableName":"zhaopinLiuyan"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "删除"
                        ],
                        "menu":"职位收藏管理",
                        "menuJump":"列表",
                        "tableName":"zhaopinCollection"
                    }
					,
					{
                        "buttons":[
                            "查看",
                            "审核",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"兼职报名管理",
                        "menuJump":"列表",
                        "tableName":"zhaopinYuyue"
                    }
					,
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"面试记录管理",
                        "menuJump":"列表",
                        "tableName":"mianshijilu"
                    }
                ],
                "menu":"职位招聘管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"用工部门管理",
                        "menuJump":"列表",
                        "tableName":"gongsi"
                    }
                ],
                "menu":"用工部门管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"学生管理",
                        "menuJump":"列表",
                        "tableName":"yonghu"
                    }
                ],
                "menu":"学生管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"轮播图管理",
                        "menuJump":"列表",
                        "tableName":"config"
                    }
                ],
                "menu":"轮播图信息"
            }
        ],
        "frontMenu":[],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"否",
        "hasFrontRegister":"否",
        "roleName":"管理员",
        "tableName":"users"
    }
	,
	{
        "backMenu":[
            {
                "child":[
                    {
                        "buttons":[
                            "查看"
                        ],
                        "menu":"公告信息管理",
                        "menuJump":"列表",
                        "tableName":"news"
                    }
                ],
                "menu":"公告信息管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改"
                        ],
                        "menu":"薪资管理",
                        "menuJump":"列表",
                        "tableName":"xinzi"
                    }
                ],
                "menu":"薪资管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"职位招聘管理",
                        "menuJump":"列表",
                        "tableName":"zhaopin"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "修改"
                        ],
                        "menu":"职位留言管理",
                        "menuJump":"列表",
                        "tableName":"zhaopinLiuyan"
                    }
					,
					{
                        "buttons":[
                            "查看",
                            "审核"
                        ],
                        "menu":"兼职报名管理",
                        "menuJump":"列表",
                        "tableName":"zhaopinYuyue"
                    }
					,
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"面试记录管理",
                        "menuJump":"列表",
                        "tableName":"mianshijilu"
                    }
                ],
                "menu":"职位招聘管理"
            }
        ],
        "frontMenu":[],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"否",
        "hasFrontRegister":"否",
        "roleName":"用工部门",
        "tableName":"gongsi"
    }
]
    }
}
export default menu;
