import {Component, OnInit} from '@angular/core';
import Cropper from 'cropperjs';
import {FileService} from '../../../common/restService/FileService';

@Component({
  selector: 'app-cropper-img',
  templateUrl: './cropper-img.component.html',
  styleUrls: ['./cropper-img.component.less'],
  providers: [FileService]
})
export class CropperImgComponent implements OnInit {
  dialog = false;
  cropper = {}

  constructor(private fileService: FileService) {
  }

  ngOnInit() {
    let image = document.getElementById('image');
    this.cropper = new Cropper(image, {
      viewMode: 2,
      aspectRatio: 1 / 1,
      autoCropArea: 0.8,
      cropBoxResizable: false,
      crop: function (e) {
        console.log(e.detail.x);
        console.log(e.detail.y);
        console.log(e.detail.width);
        console.log(e.detail.height);
        console.log(e.detail.rotate);
        console.log(e.detail.scaleX);
        console.log(e.detail.scaleY);
      }
    });

    // Import image
    const inputImage = <HTMLInputElement>document.getElementById('inputImage');
    const URL = window.URL;
    let blobURL;

    if (URL) {
      const that = this;
      inputImage.onchange = function () {
        const files = inputImage.files;
        let file;

        if (that.cropper && files && files.length) {
          file = files[0];

          if (/^image\/\w+/.test(file.type)) {
            blobURL = URL.createObjectURL(file);
            that.cropper.reset().replace(blobURL);
          } else {
            window.alert('Please choose an image file.');
          }
        }
        $(inputImage).find("img").hide();
      };
    } else {
      inputImage.disabled = true;
    }

  }

  showDialog() {
    this.dialog = true;
    document.getElementById('inputImage').click();
  }

  putb64(fileImg, token) {

    const pic = fileImg.split(',')[1];
    const url = 'http://upload-z2.qiniu.com/putb64/-1';
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4) {
        // document.getElementById("myDiv").innerHTML = xhr.responseText;
      }
    };
    xhr.open('POST', url, true);
    xhr.setRequestHeader('Content-Type', 'application/octet-stream');
    xhr.setRequestHeader('Authorization', 'UpToken ' + token);
    xhr.send(pic);
  }

  save() {
    // this.dialog = false;
    const result = this.cropper.getCroppedCanvas({width: 200, height: 200});
    const fileImg = result.toDataURL('image/jpg');
    document.getElementById('cImg').src = fileImg;

    (this.fileService as any).upToken({}, {})
      .then(response => {
        if (response.code === 200) {
          this.putb64(fileImg, response.data);
        }
      });
  }


}
