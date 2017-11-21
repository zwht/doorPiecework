import {Component, OnInit} from '@angular/core';
import Cropper from 'cropperjs'

@Component({
  selector: 'app-cropper-img',
  templateUrl: './cropper-img.component.html',
  styleUrls: ['./cropper-img.component.css']
})
export class CropperImgComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
    var image = document.getElementById('image');
    var cropper = new Cropper(image, {
      autoCropArea: 0.4,
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
    var inputImage = <HTMLInputElement>document.getElementById('inputImage');
    var URL = window.URL;
    var blobURL;

    if (URL) {
      inputImage.onchange = function () {
        var files = inputImage.files;
        var file;

        if (cropper && files && files.length) {
          file = files[0];

          if (/^image\/\w+/.test(file.type)) {
            blobURL = URL.createObjectURL(file);
            cropper.reset().replace(blobURL);
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

}
