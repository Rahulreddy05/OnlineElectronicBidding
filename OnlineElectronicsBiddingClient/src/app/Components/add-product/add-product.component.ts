import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AddProductService } from 'src/app/services/add-product.service';
import { Products } from 'src/app/Tsfiles/products';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  constructor(private formBuilder:FormBuilder,private addProducts:AddProductService) { }
  addProductForm:FormGroup;
  product:Products=new Products();
  successMessage:string="";
  failureMessage:string="";
  selectedFile:File;
  fileToUpload:File;
  ngOnInit() {
    this.addProductForm=this.formBuilder.group({
      name:['',[Validators.required]],
      discription:['',[Validators.required]],
      price:['',[Validators.required]],
      image:['',[Validators.required]],
      startDate:['',[Validators.required]],
      category:['',[Validators.required]]
    });
  }
  form=new FormGroup({
    name:new FormControl(),
  
  })

  get name()
  {
    return this.addProductForm.get('name');
  }
  get discription()
  {
    return this.addProductForm.get('discription');
  }
  get price()
  {
    return this.addProductForm.get('price');
  }
  get startDate()
  {
    return this.addProductForm.get('startDate');
  }

  get category()
  {
    return this.addProductForm.get('category');
  }
  get image()
  {
    return this.addProductForm.get('image');
  }
  onFileChanged(event){
    this.selectedFile=event.target.files[0];
  }

  onUpload(){
    this.fileToUpload=this.selectedFile;
    console.log(this.fileToUpload);
    this.addProducts.uploadImage(this.fileToUpload).subscribe(
      response=> {
        if(response!=null)
        {
          console.log("Image Uploaded Sucessfully")
        }
      }
    )
  }

  addProduct()
  {
    console.log(this.addProductForm.controls.image.value);
    this.product.name=this.addProductForm.controls.name.value;
    this.product.category=this.addProductForm.controls.category.value;
    this.product.discription=this.addProductForm.controls.discription.value;
    this.product.price=this.addProductForm.controls.price.value;
    this.product.startDate=this.addProductForm.controls.startDate.value;
   
    this.addProducts.addProduct(this.product).subscribe(
      data=>{
        if(data!=null)
        {
          this.successMessage="Product SuccessFully Added"
        }
        else{
          this.failureMessage="Product Not Added";
        }
      }
    );

  }

}
