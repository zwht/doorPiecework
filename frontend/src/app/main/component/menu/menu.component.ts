import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.less']
})
export class MenuComponent implements OnInit {
  menu = [];

  constructor(private router: Router) {
  }

  ngOnInit() {
    this.router.config.forEach(item => {
      if (item.data && (item.data as any).menu) {
        const itemMenu = {path: item.path, name: (item.data as any).name, children: []};
        if ((item as any)._loadedConfig && (item as any)._loadedConfig.routes) {
          (item as any)._loadedConfig.routes.forEach(subItem => {
            subItem.children.forEach(subSubItem => {
              if (subSubItem.data && subSubItem.data.menu) {
                itemMenu.children.push({
                  path: item.path + '/' + subSubItem.path,
                  name: subSubItem.data.name
                });
              }
            });
          });
        }
        this.menu.push(itemMenu);
      }
    });
    this.setActiveMenu(this.router.url, '/');
  }

  //设置菜单选中
  setActiveMenu(url, br) {
    this.menu.forEach(item => {
      let isActive = false;
      item.children.forEach(subItem => {
        if (br + subItem.path === url) {
          subItem.active = true;
          isActive = true;
        } else {
          subItem.active = false;
        }
      });
      if (isActive || br + item.path === url) {
        item.active = true;
        item.show = true;
      } else {
        item.active = false;
      }
    });
  }

  goMenu(item) {
    this.setActiveMenu(item.path, '');
    this.router.navigate([item.path]);
  }

  bigMenu(item) {
    item.show = !item.show;
  }
}
