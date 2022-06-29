<template>

  <div class="homeBox">
    <loading  v-if="isLoading" margin-top="10%" style="margin-left: 750px"></loading>
  <el-container style="height: 100% ; width: 100%" >
    <el-dialog
        title="提示"
        :visible.sync="dialogVisible1"
        width="30%"
        >
      <span>确定丢弃吗？</span>
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
      <span>确定摄取吗？</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible2 = false">取 消</el-button>
    <el-button type="primary" @click="handleEat">确 定</el-button>
  </span>
    </el-dialog>

    <el-dialog
        title="提示"
        :visible.sync="dialogVisible3"
        width="30%"
    >
      <span>确定装备吗？</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible3 = false">取 消</el-button>
    <el-button type="primary" @click="handleEquip">确 定</el-button>
  </span>
    </el-dialog>

    <el-dialog
        title="提示"
        :visible.sync="dialogVisible4"
        width="30%"
    >
      <div style="display: flex;flex-direction: column;justify-content: center;align-items: center;">
        <span>数量:{{currentNum}}</span>
        <span>重量:{{currentWeight}}</span>
        <span>描述:{{currentDescribe}}</span>
        <div v-if="currentId === '0001'||currentId ==='0002'||currentId ==='0003'" style="display: flex;flex-direction: column;justify-content: center;align-items: center;">
          <span>负重加成:{{currentAddWeight}}</span>
          <span>攻击加成:{{currentAddAttack}}</span>
          <span>生命力恢复:{{currentAddHealth}}</span>
        </div>
        <div v-if="currentId === '0004'||currentId ==='0005'||currentId ==='0006'" style="display: flex;flex-direction: column;justify-content: center;align-items: center;">
          <span>价值:{{currentValue}}</span>
        </div>
        <div v-if="currentId === '0007'||currentId ==='0008'||currentId ==='0009'" style="display: flex;flex-direction: column;justify-content: center;align-items: center;">
          <span>武器攻击力:{{currentWeaponAttack}}</span>
          <span>武器耐久力:{{currentDurable}}</span>
        </div>
      </div>

      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible4 = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible4 = false">确 定</el-button>
  </span>
    </el-dialog>

    <el-aside width="400px">
      <div class = "name">name:{{player_name}}</div>
      <div style="display: flex">
        <div class="health" style="margin-right: 150px; margin-left: 10px">血量:{{health}}</div>
        <div class="weight">剩余负重:{{weight}}KG</div>
      </div>
      <div style="display: flex">
        <div class="money" style="margin-right: 80px; margin-left: 10px">金钱:{{money}}</div>
        <div class="weapon" style="margin-right: 80px">装备:{{weapon}}</div>
        <div class="weapon">攻击:{{attack}}</div>
      </div>
      <div class="bag">我的背包</div>
      <div class="table_container">
        <el-table  border height="500"  :data="bag_data" >
          <el-table-column prop="item.name" label="物品" align="center" width = "79"></el-table-column>
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
      <el-header>
        <span style="margin: auto">当前房间:{{room_name}}</span>
        <el-button type="primary" style="margin: auto 10px" @click = "handleReturn">返回上一间房间</el-button>
        <el-button type="primary" style="margin: auto 10px" @click = "flush">刷新</el-button>
        <el-button type="primary" style="margin: auto 10px" @click = "save">保存信息</el-button>
        <el-button type="primary" style="margin: auto 10px" @click = "quit">退出</el-button>
      </el-header>
      <el-main>
        <div class="left">
          <div class="cover" v-for="(item,index) in datalist" :id="index" @click="handleClick($event)">
            <img v-if=" index === 2||index === 10||index === 14||index === 22"  :src="require(`../assets/2.png`)" width="100%" height="100%" alt=" " >
            <img v-else :src="require(`../assets/${item.id}.png`)" width="100%" height="100%" alt=" " >
          </div>
        </div >
        <div class="right">
          <div class="right_up">
            <div v-html="longDescription"></div>
          </div>
          <div class="right_down">
            <div>提示</div>
            <div v-html="message"></div>
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
import  Loading from './loading-component'
export default {
  name: "Home",
  components: {
    Loading,
  },
  data () {
    return{
      dialogVisible1: false,
      dialogVisible2: false,
      dialogVisible3: false,
      dialogVisible4: false,
      isLoading:false,
      room_name:'',
      room_id:'',
      player_name:'',
      player_id:'',
      attack:'',
      health:'',
      money:'',
      weapon:'',
      weight:'',
      direction:'',
      message:'',
      datalist:[],
      description:"",
      itemsDescription:'',
      longDescription:'',
      currentIndex:"",//选中的表格行号
      currentNum:'',
      currentWeight:'',
      currentId:'',
      currentDescribe:'',
      currentAddWeight:'',
      currentAddAttack:'',
      currentAddHealth:'',
      currentValue:'',
      currentWeaponAttack:'',
      currentDurable:'',
      currentPlayer:'',
      bag_data:[]
    }
  },

  mounted () {
    this.init(this.$route.params.player_id)
  },
  methods: {
    handleClick(e) {
      var index = e.currentTarget.id;
      console.log(index)
      if (index == 2) {
        this.direction = "north"
        this.goNext(this.player_id,this.direction)
      }
      else if (index == 10) {
        this.direction = "west"
        this.goNext(this.player_id,this.direction)
      }
      else if (index == 14) {
        this.direction = "east"
        this.goNext(this.player_id,this.direction)
      }
      else if (index == 22) {
        this.direction = "south"
        this.goNext(this.player_id,this.direction)
      }
      else if(this.datalist[index].id === 1){
        this.datalist[index].id = 3
        this.datalist[this.currentPlayer].id = 1
        this.currentPlayer = index
      }
      else if(this.datalist[index].id == "1001"||this.datalist[index].id == "1002"){
        var that=this
        this.$http.get("http://lkpttxg.cn:80/worldOfZuul/player/attack/"+that.player_id+"?location="+index,{
          emulateJSON: true
        }).then(function (res) {
          console.log("攻击怪物",res.data)
          if (res.data.code === 200){
            that.message = res.data.message
            that.datalist = res.data.data.currentRoom.objects
            that.description = res.data.data.currentRoom.description
            that.itemsDescription = res.data.data.currentRoom.itemsDescription
            that.longDescription = res.data.data.currentRoom.longDescription
            that.room_id = res.data.data.currentRoom.id
            that.room_name = res.data.data.currentRoom.name
            that.player_id = res.data.data.id
            that.player_name = res.data.data.name
            that.attack = res.data.data.attack
            that.health = res.data.data.health
            that.money = res.data.data.money
            that.weapon = res.data.data.weapon
            that.weight = res.data.data.weight
            that.bag_data = res.data.data.arrBag
            that.datalist[index].id = 3
            that.datalist[this.currentPlayer].id = 1
            that.currentPlayer = index
          }
          else if(res.data.code === 201){
            that.message = res.data.message
            that.datalist = res.data.data.currentRoom.objects
            that.description = res.data.data.currentRoom.description
            that.itemsDescription = res.data.data.currentRoom.itemsDescription
            that.longDescription = res.data.data.currentRoom.longDescription
            that.room_id = res.data.data.currentRoom.id
            that.room_name = res.data.data.currentRoom.name
            that.player_id = res.data.data.id
            that.player_name = res.data.data.name
            that.attack = res.data.data.attack
            that.health = res.data.data.health
            that.money = res.data.data.money
            that.weapon = res.data.data.weapon
            that.weight = res.data.data.weight
            that.bag_data = res.data.data.arrBag
            that.datalist[this.currentPlayer].id = 3
          }
          else {
            that.message = res.data.message
          }
        })
      }
      else {
        var that=this
        console.log("拾取",index)
        this.$http.get("http://lkpttxg.cn:80/worldOfZuul/player/pick/"+that.player_id+"?location="+index,{
          emulateJSON: true
        }).then(function (res) {
          if (res.data.code === 200){
            console.log("拾取成功",res.data)
            that.message = res.data.message
            that.datalist = res.data.data.currentRoom.objects
            that.description = res.data.data.currentRoom.description
            that.itemsDescription = res.data.data.currentRoom.itemsDescription
            that.longDescription = res.data.data.currentRoom.longDescription
            that.room_id = res.data.data.currentRoom.id
            that.room_name = res.data.data.currentRoom.name
            that.player_id = res.data.data.id
            that.player_name = res.data.data.name
            that.attack = res.data.data.attack
            that.health = res.data.data.health
            that.money = res.data.data.money
            that.weapon = res.data.data.weapon
            that.weight = res.data.data.weight
            that.bag_data = res.data.data.arrBag
            that.datalist[index].id = 3
            that.datalist[this.currentPlayer].id = 1
            that.currentPlayer = index
            console.log("ok")
          }
          else {
            that.message = res.data.message
          }
        })
      }

    },

    operate_throw(index) {
      this.currentIndex = index
      this.currentId = this.bag_data[this.currentIndex].item.id
      this.dialogVisible1 = true
    },
    operate_eat(index) {
      this.currentIndex = index
      this.currentId = this.bag_data[this.currentIndex].item.id
      this.dialogVisible2 = true
    },
    operate_equip (index) {
      this.currentIndex = index
      this.currentId = this.bag_data[this.currentIndex].item.id
      this.dialogVisible3 = true
    },
    operate_detail(index) {
      this.currentIndex = index
      console.log("333",this.bag_data[this.currentIndex].item.id)
      if(this.bag_data[this.currentIndex].item.id == "0001"||
          this.bag_data[this.currentIndex].item.id =="0002"||
          this.bag_data[this.currentIndex].item.id =="0003"){
        this.currentNum = this.bag_data[this.currentIndex].number
        this.currentWeight = this.bag_data[this.currentIndex].item.weight
        this.currentId = this.bag_data[this.currentIndex].item.id
        this.currentDescribe = this.bag_data[this.currentIndex].item.describe
        this.currentAddWeight = this.bag_data[this.currentIndex].item.addWeight
        this.currentAddAttack = this.bag_data[this.currentIndex].item.addAttack
        this.currentAddHealth = this.bag_data[this.currentIndex].item.addHealth
        this.dialogVisible4 = true
      }
      else if(this.bag_data[this.currentIndex].item.id == "0004"||
          this.bag_data[this.currentIndex].item.id =="0005"||
          this.bag_data[this.currentIndex].item.id =="0006"){
        this.currentNum = this.bag_data[this.currentIndex].number
        this.currentWeight = this.bag_data[this.currentIndex].item.weight
        this.currentId = this.bag_data[this.currentIndex].item.id
        this.currentDescribe = this.bag_data[this.currentIndex].item.describe
        this.currentValue = this.bag_data[this.currentIndex].item.value
        this.dialogVisible4 = true
      }
      else {
        this.currentNum = this.bag_data[this.currentIndex].number
        this.currentWeight = this.bag_data[this.currentIndex].item.weight
        this.currentId = this.bag_data[this.currentIndex].item.id
        this.currentDescribe = this.bag_data[this.currentIndex].item.describe
        this.currentWeaponAttack = this.bag_data[this.currentIndex].item.weaponAttack
        this.currentDurable = this.bag_data[this.currentIndex].item.durable
        this.dialogVisible4 = true
      }
    },

    handleThrow() {
      var that=this
      console.log("id",that.currentId)
      this.$http.get("http://lkpttxg.cn:80/worldOfZuul/player/throw/"+that.player_id+"?id="+that.currentId,{
        emulateJSON: true
      }).then(function (res) {
        //console.log("丢弃成功",res.data)
        if (res.data.code === 200){
          console.log("丢弃成功",res.data)
          that.$message.success(res.data.message)
          that.datalist = res.data.data.currentRoom.objects
          that.description = res.data.data.currentRoom.description
          that.itemsDescription = res.data.data.currentRoom.itemsDescription
          that.longDescription = res.data.data.currentRoom.longDescription
          that.room_id = res.data.data.currentRoom.id
          that.room_name = res.data.data.currentRoom.name
          that.player_id = res.data.data.id
          that.player_name = res.data.data.name
          that.attack = res.data.data.attack
          that.health = res.data.data.health
          that.money = res.data.data.money
          that.weapon = res.data.data.weapon
          that.weight = res.data.data.weight
          that.bag_data = res.data.data.arrBag
          that.datalist[that.currentPlayer].id = 3
        }
        else {
          console.log("失败")
          that.$message.error(res.data.message)
        }
      })
      this.dialogVisible1 = false
    },

    handleEat() {
      var that=this
      this.$http.get("http://lkpttxg.cn:80/worldOfZuul/player/eat/"+that.player_id+"?id="+that.currentId,{
        emulateJSON: true
      }).then(function (res) {
        console.log("摄取成功",res.data)
        if (res.data.code === 200){
          that.$message.success(res.data.message)
          that.datalist = res.data.data.currentRoom.objects
          that.description = res.data.data.currentRoom.description
          that.itemsDescription = res.data.data.currentRoom.itemsDescription
          that.longDescription = res.data.data.currentRoom.longDescription
          that.room_id = res.data.data.currentRoom.id
          that.room_name = res.data.data.currentRoom.name
          that.player_id = res.data.data.id
          that.player_name = res.data.data.name
          that.attack = res.data.data.attack
          that.health = res.data.data.health
          that.money = res.data.data.money
          that.weapon = res.data.data.weapon
          that.weight = res.data.data.weight
          that.bag_data = res.data.data.arrBag
          that.datalist[that.currentPlayer].id = 3
        }
        else {
          that.$message.error(res.data.message)
        }
      })
      this.dialogVisible2 = false
    },

    handleEquip() {
      var that=this
      this.$http.get("http://lkpttxg.cn:80/worldOfZuul/player/equip/"+that.player_id+"?id="+that.currentId,{
        emulateJSON: true
      }).then(function (res) {
        console.log("装备成功",res.data)
        if (res.data.code === 200){
          that.$message.success(res.data.message)
          that.datalist = res.data.data.currentRoom.objects
          that.description = res.data.data.currentRoom.description
          that.itemsDescription = res.data.data.currentRoom.itemsDescription
          that.longDescription = res.data.data.currentRoom.longDescription
          that.room_id = res.data.data.currentRoom.id
          that.room_name = res.data.data.currentRoom.name
          that.player_id = res.data.data.id
          that.player_name = res.data.data.name
          that.attack = res.data.data.attack
          that.health = res.data.data.health
          that.money = res.data.data.money
          that.weapon = res.data.data.weapon
          that.weight = res.data.data.weight
          that.bag_data = res.data.data.arrBag
          that.datalist[that.currentPlayer].id = 3
        }
        else {
          that.$message.error(res.data.message)
        }
      })
      this.dialogVisible3 = false
    },


    init (id) {
      var that=this
      this.$http.get("http://lkpttxg.cn:80/worldOfZuul/player/"+id,{
        emulateJSON: true
      }).then(function (res) {
        console.log("初始化成功",res.data)
        if (res.data.code === 200){
          that.message = res.data.message
          that.datalist = res.data.data.currentRoom.objects
          that.description = res.data.data.currentRoom.description
          that.itemsDescription = res.data.data.currentRoom.itemsDescription
          that.longDescription = res.data.data.currentRoom.longDescription
          that.room_id = res.data.data.currentRoom.id
          that.room_name = res.data.data.currentRoom.name
          that.player_id = res.data.data.id
          that.player_name = res.data.data.name
          that.attack = res.data.data.attack
          that.health = res.data.data.health
          that.money = res.data.data.money
          that.weapon = res.data.data.weapon
          that.weight = res.data.data.weight
          that.bag_data = res.data.data.arrBag
          that.currentPlayer = 12
          that.datalist[that.currentPlayer].id = 3
        }
        else {
          that.message = res.data.message
        }
      })
    },
    handleReturn(){
      var that=this
      this.$http.get("http://lkpttxg.cn:80/worldOfZuul/player/back/"+that.player_id,{
        emulateJSON: true
      }).then(function (res) {
        console.log("回退成功",res.data)
        if (res.data.code === 200){
          that.message = res.data.message
          that.datalist = res.data.data.objects
          that.description = res.data.data.description
          that.itemsDescription = res.data.data.itemsDescription
          that.longDescription = res.data.data.longDescription
          that.room_id = res.data.data.id
          that.room_name = res.data.data.name
          that.currentPlayer = 12
          that.datalist[that.currentPlayer].id = 3
        }
        else {
          that.message = res.data.message
        }
      })
    },
    save(){
      var that=this
      this.$http.get("http://lkpttxg.cn:80/worldOfZuul//settings/save"+"?id="+that.player_id,{
        emulateJSON: true
      }).then(function (res) {
        console.log("成功",res.data)
        if (res.data.code === 200){
          that.message = res.data.message
        }
        else {
          that.message = res.data.message
        }
      })
    },
    flush(){
      var that=this
      this.$http.get("http://lkpttxg.cn:80/worldOfZuul//settings/flush",{
        emulateJSON: true
      }).then(function (res) {
        console.log("成功",res.data)
        if (res.data.code === 200){
          that.message = res.data.message
        }
        else {
          that.message = res.data.message
        }
      })
    },
    quit(){
      this.$router.replace('/index')
    },
    goNext(id , direction){
      this.isLoading = true
      var that=this
      this.$http.get("http://lkpttxg.cn:80/worldOfZuul/player/next/"+id+"/"+direction,{
        emulateJSON: true
      }).then(function (res) {
        setTimeout(function () {
          that.isLoading = false
        },0.5*1000)
        console.log("去往下一个房间成功",res.data)
        if (res.data.code === 200){
          that.message = res.data.message
          that.datalist = res.data.data.objects
          that.description = res.data.data.description
          that.itemsDescription = res.data.data.itemsDescription
          that.longDescription = res.data.data.longDescription
          that.room_id = res.data.data.id
          that.room_name = res.data.data.name
          that.currentPlayer = 12
          that.datalist[that.currentPlayer].id = 3
        }
        if (res.data.code === 300){
          that.message = res.data.message
          that.datalist = res.data.data.objects
          that.description = res.data.data.description
          that.itemsDescription = res.data.data.itemsDescription
          that.longDescription = res.data.data.longDescription
          that.room_id = res.data.data.id
          that.room_name = res.data.data.name
          that.currentPlayer = 12
          that.datalist[that.currentPlayer].id = 3
        }
        else {
          that.message = res.data.message
        }
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
.el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
}
.el-header{
  background-color: #B3C0D1;
  color: #333;
  display: flex;
}

.el-aside {
  background-color: #D3DCE6;
  /*background-image: url("../assets/player_info_bcg.png");*/
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
  width:50%;
  height: 500px;
  margin-left: 50px;
  /*line-height: 50px;*/
}
.right_up{
  /*width:40%;*/
  /*display: flex;*/
  height: 50%;
  border:1px solid #000;
  margin-bottom: 50px;
}
.right_down{
  /*width:40%;*/
  /*display: flex;*/
  height: 50%;
  border:1px solid #000;
}

body > .el-container {
  margin-bottom: 40px;
}
</style>
