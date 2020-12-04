import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Observable } from 'rxjs';
import { HomeService } from 'src/app/services/home.service';
import { Products } from 'src/app/Tsfiles/products';

@Component({
  selector: 'app-bidding',
  templateUrl: './bidding.component.html',
  styleUrls: ['./bidding.component.css']
})
export class BiddingComponent implements OnInit {

  product:Products[];
  clickedId:any;
  imageUrl:any;
  image:any;
  realImage:any;
  num:number;
  responseImageData:any;
  message:String;
  constructor(private homeService:HomeService,private sanitizer: DomSanitizer) { }

  ngOnInit() {
    this.getImages();
    this.clickedId=this.homeService.bProduct();
    this.homeService.getHomeData().subscribe(
      (data:any)=>{
        console.log(data),
        //console.log(this.clickedId);
        this.product=data
      }  
      )
    console.log(this.clickedId);
  }
  getImage(numb:number)
  {
    this.num=numb;
    //console.log(this.num);
    this.imageUrl = 'data:image/jpeg;base64,' + this.responseImageData[this.num-1].picByte;
    this.image = this.sanitizer.bypassSecurityTrustUrl(this.imageUrl);
    return this.image;
  }
  getImages()
  {
    this.homeService.getImages().subscribe(
      (data:any)=>
      {
        this.responseImageData=data
        //console.log(data);
        // this.num=1
        //this.imageUrl = 'data:image/jpeg;base64,' + data[this.num].picByte;
        //console.log(this.imageUrl);
        //this.image = this.sanitizer.bypassSecurityTrustUrl(this.imageUrl);
      }
    )
  }
  bidded()
  {
    this.message="Your Bid SuccessFully Placed"
  }


}
