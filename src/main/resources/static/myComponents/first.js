Vue.component('first-dialog', {
    //template[]内为组件的具体内容   'first-dialog'要与调用时的<first-dialog></first-dialog>对应
    template:[
        '<div>',
        '<el-dialog :title="title" :visible.sync="visible">',
        '哈哈哈哈哈哈',
        '{{monitor}}',
        '<span slot="footer" class="dialog-footer">',
        '<el-button @click="visible = false">取 消</el-button>',
            '<el-button type="primary" @click="closeDialog">确 定</el-button>',
        '</span>',
        '</el-dialog>',
        '</div>',
    ].join(''),
    data() {
        return {
            //具体的属性内容
            title:'我的第一个自己的组件',
            visible:false,
        }
    },
    props: {
      //组件的监听字段  会随着调用方的内容改变而改变
        monitor: {
            type: String,
            default: '默认的内容',
            note:'',
        },
    },
    created:function (){


    },
    methods: {
        //组件内部的具体方法
          open(){
              this.visible=true
          },
        closeDialog(){
              this.note="这是组件里传递的内容"
              console.log(this.note)
              this.visible=false
              this.$emit('closedialog',this.note)
            },
    },
    computed: {
         //计算的具体方法
    },

    mounted: function () {

    }
})