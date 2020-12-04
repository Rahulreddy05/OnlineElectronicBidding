import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { HomeService } from 'src/app/services/home.service';
import { Products } from 'src/app/Tsfiles/products';

@Component({
  selector: 'app-laptops',
  templateUrl: './laptops.component.html',
  styleUrls: ['./laptops.component.css']
})
export class LaptopsComponent implements OnInit {

  product:Products=new Products();
  product1:Products[];
  Name:String;
  imageUrl:any;
  image:any;
  realImage:any;
  num:number;
  responseImageData:any;
  constructor(private homeService:HomeService,private sanitizer: DomSanitizer) { }

  ngOnInit() {
    this.getProducts();
    this.getImages();
  }
  getProducts()
  {
 
    this.homeService.getHomeData().subscribe(
      (data:any)=>{
        console.log(data),
        
        this.product1=data,
        this.Name="hello"
      }  
      )
      
  }
 getImage(numb:number)
 {
   this.num=numb;
   console.log(this.num);
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
}
