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
                itemMenu.children.push({path: item.path + '/' + subSubItem.path,
                  name: subSubItem.data.name});
              }
            });
          });
        }
        this.menu.push(itemMenu);
      }
    });
  }
  goMenu(item){
    this.router.navigate([item.path]);
  }
}
