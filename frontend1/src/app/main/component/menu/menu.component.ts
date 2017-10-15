import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  menu=[];
  constructor(private router:Router) { }
  ngOnInit() {
    this.router.config.forEach(item=>{
      if(item.data&&item.data.menu){
        let itemMenu={path:item.path,children:[]};
        if((item as any)._loadedConfig&&(item as any)._loadedConfig.routes){
          (item as any)._loadedConfig.routes.forEach(subItem=>{
            subItem.children.forEach(subSubItem=>{
              if(subSubItem.data&&subSubItem.data.menu){
                itemMenu.children.push({path:item.path+"/"+subSubItem.path})
              }
            })
          })
        }
        this.menu.push(itemMenu);
      }
    })
  }

}
