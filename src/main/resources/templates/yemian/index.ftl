<!DOCTYPE html>
<html lang="en">
<head>
    <#include "./common/common.ftl"/>
</head>
<body>
23333
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
        <span>这是一段信息</span>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
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
    </div>
</body>
</html>
<script>
    var vm = new Vue({
        el: '#rrapp',
        data: {
            adornUrl:"download",
            downloadUrl:"modeldownload",
            docdownloadUrl:"doc",
            testTitle:'',
            dialogVisible:false,
            fileList:[],
        },
    methods: {
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
            console.log("sadasd")
            var xhr = new XMLHttpRequest();
            xhr.open('GET', this.adornUrl, true);        // 也可以使用POST方式，根据接口
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