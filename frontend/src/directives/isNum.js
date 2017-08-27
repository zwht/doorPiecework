export default function (Vue) {
  Vue.directive("isNum",{
    inserted(el){
      let ctrl = false;
      let arr = [65,67,86,88,90];//a,c,v,x,z
      el.onkeydown=function (e) {
        console.log(e.which);
        if(ctrl&&arr.includes(e.which))return;
        if(e.which===17)ctrl=true;
        let v =e.target.value;
        let t =v+e.key;
        if(e.key.length-1)return
        if(Number.isNaN(Number(t)))e.preventDefault();
      };
      el.onkeyup=function (e) {
        if(e.which===17)ctrl=false;
      };
    }
  });
}












