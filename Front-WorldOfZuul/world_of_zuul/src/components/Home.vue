<template>
  <div class="homeBox">
  <el-container style="height: 100% ; width: 100%" >
    <el-dialog
        title="提示"
        :visible.sync="dialogVisible1"
        width="30%"
        >
      <el-input v-model="input" placeholder="请输入数量 "></el-input>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible1 = false">取 消</el-button>
    <el-button type="primary" @click="handleThrow">确 定</el-button>
  </span>
    </el-dialog>

    <el-dialog
        title="提示"
        :visible.sync="dialogVisible2"
        width="30%"
    >
      <el-input v-model="input" placeholder="请输入数量"></el-input>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible2 = false">取 消</el-button>
    <el-button type="primary" @click="handleEat">确 定</el-button>
  </span>
    </el-dialog>

<!--    <el-dialog-->
<!--        title="提示"-->
<!--        :visible.sync="dialogVisible3"-->
<!--        width="30%"-->
<!--    >-->
<!--      <el-input v-model="input" placeholder="请输入数量"></el-input>-->
<!--      <span slot="footer" class="dialog-footer">-->
<!--    <el-button @click="dialogVisible = false">取 消</el-button>-->
<!--    <el-button type="primary" @click="handleEquip">确 定</el-button>-->
<!--  </span>-->
<!--    </el-dialog>-->

    <el-dialog
        title="提示"
        :visible.sync="dialogVisible4"
        width="30%"
    >
      <div style="display: flex;flex-direction: column;justify-content: center;align-items: center;">
        <span>数量:{{currentNum}}</span>
        <span>重量:{{currentWeight}}</span>
        <span>可执行操作:</span>
      </div>

      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible4 = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible4 = false">确 定</el-button>
  </span>
    </el-dialog>

    <el-aside width="400px">
      <div class = "name">name:yc</div>
      <div style="display: flex">
        <div class="carried" style="margin-right: 50px; margin-left: 10px">已携带物品重量:{{carried}}KG</div>
        <div class="remain">还能携带物品重量:{{remain}}KG</div>
      </div>
      <div style="display: flex">
        <div class="blood" style="margin-right: 150px; margin-left: 10px">血量:{{blood}}</div>
        <div class="equipment">装备:{{equipment}}</div>
      </div>
      <div class="bag">我的背包</div>
      <div class="table_container">
        <el-table  border height="500"  :data="bag_data" >
          <el-table-column prop="item" label="物品" align="center" width = "79"></el-table-column>
<!--          <el-table-column prop="weight" label="重量" align="center" width = "99"></el-table-column>-->
<!--          <el-table-column prop="num" label="数量" align="center" width = "99"></el-table-column>-->
          <el-table-column label="操作" type="index" align="center" width = "320" style="display: flex">
            <template slot-scope="scope">
              <div style="margin-bottom: 10px">
                <ElButton type="primary" @click="operate_throw(scope.$index)">丢弃</ElButton>
                <ElButton type="primary" @click="operate_eat(scope.$index)">摄取</ElButton>
              </div>
              <div>
                <ElButton type="primary" @click="operate_equip(scope.$index)">装备</ElButton>
                <ElButton type="primary" @click="operate_detail(scope.$index)">详情</ElButton>
              </div>

            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-aside>
    <el-container direction="vertical">
      <el-header>当前房间:{{room}}</el-header>
      <el-main>
        <div class="left">
          <div class="cover" v-for="(item,index) in datalist" :id="index" @click="handleClick($event)"><img :src="require(`../assets/${item}.png`)" width="100%" height="100%" alt=" " ></div>
        </div >
        <div class="right">
          <div class="right_up">
            <div>房间描述</div>
            <div>{{description}}</div>
          </div>
          <div class="right_down">
            <el-button type="primary">返回上一间房间</el-button>
          </div>
        </div>

      </el-main>
      <el-footer>
        Copyright © 2022 杨灿,林冠成,刘磊,马必争
      </el-footer>
    </el-container>
  </el-container>
  </div>
</template>

<script>
export default {
  name: "Home",
  data () {
    return{
      dialogVisible1: false,
      dialogVisible2: false,
      dialogVisible3: false,
      dialogVisible4: false,
      room:"入口",
      //2为入口，1为空白，3为人，>3为物品
      datalist:[1,1,2,1,1,1,5,1,1,1,2,4,3,1,2,5,1,1,1,1,4,1,2,1,5],
      current:12,//当前人物所在位置
      carried:0,
      remain:0,
      blood:0,
      equipment:"手枪",
      description:"",
      input: '',//丢弃数量文本框
      currentIndex:"",//选中的表格行号
      currentNum:'',
      currentWeight:'',
      //table数据
      bag_data:[{item:"饼干",weight:"5",num:"5"},{item:"石头",weight:"5",num:"5"},{item:"手枪",weight:"5",num:"5"},{item:"冲锋枪",weight:"5",num:"5"}]
    }
  },

  mounted () {
    this.init("3001")
  },
  methods: {
    handleClick(e) {
      var index = e.currentTarget.id;
      console.log(index)
      console.log(this.datalist[index])
      if (this.datalist[index] === 1) {
        console.log(111)
        this.$set(this.datalist, index, 3);
        this.$set(this.datalist, this.current, 1);
        this.current = index
      }
      if (this.datalist[index] > 3) {

      }
    },

    operate_throw(index) {
      this.currentIndex = index
      this.dialogVisible1 = true
    },
    operate_eat(index) {
      this.currentIndex = index
      this.dialogVisible2 = true
    },
    operate_equip (index) {
      // this.currentIndex = index
      // this.dialogVisible3 = true
    },
    operate_detail(index) {
      this.currentIndex = index
      this.currentNum = this.bag_data[this.currentIndex].num
      this.currentWeight = this.bag_data[this.currentIndex].weight
      this.dialogVisible4 = true
    },

    handleThrow() {
      this.bag_data[this.currentIndex].num -= this.input
      this.dialogVisible1 = false
    },

    handleEat() {
      this.bag_data[this.currentIndex].num -= this.input
      this.dialogVisible2 = false
    },

    init (id) {
      this.$http.get("http://lkpttxg.cn:80/worldOfZuul/rooms/"+id,{
        emulateJSON: true
      }).then(function (res) {
        console.log("1111",res.data)
      })
    }
  }
}
</script>

<style scoped>

#app {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #D3DCE6;
  background-image: url("../assets/player_info_bcg.png");
  color: #333;
  text-align: center;
  line-height: 50px;


}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  /*line-height: 160px;*/
  display: flex;
}
.left{
  display: grid;
  grid-template-columns: repeat(5, 110px);
  grid-template-rows: repeat(5, 110px);
  justify-items: stretch;
}
.cover{
  border:1px solid #000;
}
/*.cover{*/
/*  display: flex;*/
/*  justify-content: center;*/
/*  width: 33%;*/
/*  border:1px solid #000*/
/*}*/
.right{
  width:40%;
  height: 500px;
  margin-left: 50px;
  line-height: 50px;
}
.right_up{
  /*width:40%;*/
  height: 80%;
  border:1px solid #000;
  margin-bottom: 50px;
  line-height: 50px;
}
body > .el-container {
  margin-bottom: 40px;
}
</style>
