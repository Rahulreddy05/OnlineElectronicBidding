import { Component, OnInit } from '@angular/core';
import { ProductService } from "../../services/product.service";
import { Products } from "../../Tsfiles/products";
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products:Products[]

  constructor( private productService: ProductService) { }

  ngOnInit() {
    this.listProduct();
  }
  listProduct()
  {
    this.productService.getProductList().subscribe(
      data => {
        this.products=data;
      }
    )
  }

}
