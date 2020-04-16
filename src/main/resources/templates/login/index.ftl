<!DOCTYPE html>
<html lang="en">
<head>
    <title>SpringBoot + Freemarker</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- 引入组件库 -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>

</head>
<body>
<div id="vue">
    <div style="width: 250px;height: 300px">
    <el-form ref="ruleForm" :model="ruleForm" label-width="80px">
        <el-form-item label="用户名">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="密码">
            <el-input type="password" v-model="ruleForm.password"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="login">登陆</el-button>
            <el-button type="primary" @click="regist">注册</el-button>

        </el-form-item>
    </el-form>
    </div>
</div>
</body>
</html>
<script>
    var vm = new Vue({
        el: '#vue',
        data: {
            ruleForm:{name:'',password:''},
            dialogVisible:'',
            loginUrl:'/login/login',
        },
        methods: {
            login(){
                axios.post(this.loginUrl,this.ruleForm,this).then(function(res){
                    console.log(res.data)
                });
            },
            regist(){
                console.log("ssssss",this.ruleForm)
            }
        },
        mounted:function (){

        }
    })
</script>