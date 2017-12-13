import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {FileUploader} from 'ng2-file-upload';
@Component({
  selector: 'app-door',
  templateUrl: './door.component.html',
  styleUrls: ['./door.component.css']
})
export class DoorComponent implements OnInit {
  uploader: FileUploader = new FileUploader({
    url: '/cfmy/file/add?id=8888',
    method: 'POST',
    itemAlias: 'file',
    headers: [{
      name: 'Authorization',
      value: localStorage.getItem('token')
    }]
  });


  constructor(private router: Router) {
  }

  ngOnInit() {

  }

  go() {
    this.router.navigateByUrl('/work/door');
  }

  selectedFileOnChanged() {
    // 这里是文件选择完成后的操作处理
    this.uploader.queue[0].onSuccess = (response, status, headers) => {
      let rep = JSON.parse(response);
      // 上传文件成功
      if (status == 200) {
        // 上传文件后获取服务器返回的数据
        let tempRes = JSON.parse(response);
      } else {
        // 上传文件后获取服务器返回的数据错误
      }
      this.uploader.queue = [];
    };
    this.uploader.queue[0].upload(); // 开始上传
  }

}