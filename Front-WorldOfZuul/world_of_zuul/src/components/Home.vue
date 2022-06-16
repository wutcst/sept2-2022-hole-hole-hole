<template>
  <el-container >
    <el-aside width="400px">Aside</el-aside>
    <el-container>
      <el-header>当前房间:{{room}}</el-header>
      <el-main>
        <div class="left">
          <div class="cover" v-for="(item,index) in datalist" :id="index" @click="handleClick($event)"><img :src="require(`../assets/${item}.png`)" width="100%" height="100%" alt=" " ></div>
        </div>
        <div class="right">11</div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: "Home",
  data () {
    return{
      room:"入口",
      datalist:[1,2,4,2,3,2,5,2,1],
      current:4,
    }
  },
  methods:{
    handleClick (e) {
      var index = e.currentTarget.id;
      console.log(this.datalist[index])
      if(this.datalist[index] === 1){
        console.log(111)
        this.$set(this.datalist,index,3);
        this.$set(this.datalist,this.current,1);
        this.current = index
      }
      if(this.datalist[index] > 3){

      }
    }
  }
}
</script>

<style scoped>
.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 600px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 160px;
  display: flex;
}
.left{
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  width: 60%;

}
.cover{
  display: flex;
  justify-content: center;
  width: 33%;
  border:1px solid #000
}
.right{
  width:40%;
  border:1px solid #000;
  margin-left: 50px;
}
body > .el-container {
  margin-bottom: 40px;
}
</style>
