const base = {
    get() {
        return {
            url : "http://localhost:8080/qingongjianxue/",
            name: "qingongjianxue",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/qingongjianxue/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "大学生勤工助学管理系统"
        } 
    }
}
export default base
