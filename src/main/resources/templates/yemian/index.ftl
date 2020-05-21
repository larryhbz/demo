<!DOCTYPE html>
<html lang="en">
<head>
    <#include "./common/common.ftl"/>
</head>
<body>
    <div id="rrapp">
    <button @click="submit">excel下载</button>
    <button @click="modelDownload">模板方式excel文件下载</button>
    <button @click="docDownload">world文档下载</button>
    <el-button type="text" @click="dialogVisible = true">点击打开 Dialog</el-button>
    <el-dialog
            title="提示"
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="handleClose">
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="选择控制">
                <template>
                    <el-select v-model="form.name" placeholder="请选择" @change="selectChange">
                        <el-option
                                v-for="item in options"
                                :key="item.key"
                                :label="item.value"
                                :value="item.key">
                        </el-option>
                    </el-select>
                </template>
            </el-form-item>
            <el-form-item label="黄金糕" v-if="form.name==1">
                <el-input v-model="form.hjg" placeholder="请输入内容"></el-input>
            </el-form-item>
            <el-form-item label="双皮奶" v-if="form.name==2">
                <el-input v-model="form.spn" placeholder="请输入内容"></el-input>
            </el-form-item>
            <el-form-item label="蚵仔煎" v-if="form.name==3">
                <el-input v-model="form.haj" placeholder="请输入内容"></el-input>
            </el-form-item>
            <el-form-item label="龙须面" v-if="form.name==4">
                <el-input v-model="form.lxm" placeholder="请输入内容"></el-input>
            </el-form-item>
            <el-form-item label="选择多选控制">
                <template>
                    <el-select v-model="form.double" placeholder="请选择" multiple>
                        <el-option
                                v-for="item in options"
                                :key="item.key"
                                :label="item.value"
                                :value="item.key">
                        </el-option>
                    </el-select>
                </template>
            </el-form-item>
            <el-form-item label="黄金糕" v-if="form.double.indexOf('1')>-1">
                asdasda
            </el-form-item>
            <el-form-item label="双皮奶" v-if="form.double.indexOf('2')>-1">
                asdasda
            </el-form-item>
            <el-form-item label="蚵仔煎" v-if="form.double.indexOf('3')>-1">
                asdasda
            </el-form-item>
            <el-form-item label="龙须面" v-if="form.double.indexOf('4')>-1">
                asdasda
            </el-form-item>
        </el-form>

    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="submitForm">确 定</el-button>
  </span>
    </el-dialog>
    <el-upload
                class="upload-demo"
                action="/file/upload"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                :on-exceed="handleExceed"
                :file-list="fileList">
            <el-button size="small" type="primary">点击上传</el-button>
        </el-upload>
        <button @click="zujian">我的第一个组件</button>
        <first-dialog  :monitor="monitorNote" @closedialog="conDialog" ref="firstDialog"></first-dialog>
    </div>
</body>
</html>
<script src="/myComponents/first.js"></script>
<script>
    var vm = new Vue({
        el: '#rrapp',
        data: {
            monitorNote:'',//组件监听的内容
            adornUrl:"/yemian/download",
            downloadUrl:"/yemian/modeldownload",
            docdownloadUrl:"/yemian/doc",
            testTitle:'',
            dialogVisible:false,
            fileList:[],
            form:{
                double:'',
                name:'',
                hjg:'',
                spn:'',
                haj:'',
                lxm:'',
            },
            options:[
                {
                    key: '1',
                    value: '黄金糕'
                }, {
                    key: '2',
                    value: '双皮奶'
                }, {
                    key: '3',
                    value: '蚵仔煎'
                }, {
                    key: '4',
                    value: '龙须面'
                }, {
                    key: '5',
                    value: '北京烤鸭'
                }
            ],
        },
    methods: {
        conDialog(data){
            console.log("组件跳出来后的显示",data)
        },
        zujian(){
            this.monitorNote="changemonitorNote"
            this.$refs.firstDialog.open()
        },
        selectChange(key1,key2){
            this.form.hjg=''
            this.form.spn=''
            this.form.haj=''
            this.form.lxm=''
        },
        submitForm(){
            let that = this
            console.log(that.form)
            that.dialogVisible=false
        },
        handleRemove(file, fileList) {
            console.log(file, fileList);
        },
        handlePreview(file) {
            console.log(file);
        },
        handleExceed(files, fileList) {
            this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
        },
        beforeRemove(file, fileList) {
            return this.$confirm(`确定移除 ${ file.name }？`);
        },
        handleClose(){
            this.dialogVisible=false
        },
        daoru(){

        },
        submit: function () {
            var xhr = new XMLHttpRequest();
            xhr.open('POST', this.adornUrl, true);        // 也可以使用POST方式，根据接口
            xhr.responseType = "blob";    // 返回类型blob
            // 定义请求完成的处理函数，请求前也可以增加加载框/禁用下载按钮逻辑
            xhr.onload = function () {
                if (this.status === 200) {
                    var blob = this.response;// 获取返回值
                    var a = document.createElement('a');
                    a.download = 'test表.xlsx';
                    a.href = window.URL.createObjectURL(blob);
                    a.click();
                }
            };
            xhr.send()
        },
        modelDownload:function () {
            var xhr = new XMLHttpRequest();
            xhr.open('GET', this.downloadUrl, true);        // 也可以使用POST方式，根据接口
            xhr.responseType = "blob";    // 返回类型blob
            // 定义请求完成的处理函数，请求前也可以增加加载框/禁用下载按钮逻辑
            xhr.onload = function () {
                if (this.status === 200) {
                    var blob = this.response;// 获取返回值
                    var a = document.createElement('a');
                    a.download = 'test表.xlsx';
                    a.href = window.URL.createObjectURL(blob);
                    a.click();
                }
            };
            xhr.send()
        },
        docDownload:function () {
            var xhr = new XMLHttpRequest();
            xhr.open('GET', this.docdownloadUrl, true);        // 也可以使用POST方式，根据接口
            xhr.responseType = "blob";    // 返回类型blob
            // 定义请求完成的处理函数，请求前也可以增加加载框/禁用下载按钮逻辑
            xhr.onload = function () {
                if (this.status === 200) {
                    var blob = this.response;// 获取返回值
                    var a = document.createElement('a');
                    a.download = '歌词.doc';
                    a.href = window.URL.createObjectURL(blob);
                    a.click();
                }
            };
            xhr.send()
        }
    },
    mounted:function (){
        console.log("刷新时调用")
    }
    })
</script>