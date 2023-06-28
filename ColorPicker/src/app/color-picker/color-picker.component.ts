import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.css']
})
export class ColorPickerComponent {
  @Input() initialColor: string = "red";
  @Input() colorOptions: string[] = ['red','blue', 'green'];

  selectedColor:string='';
 
  ngOnInit(){
    this.selectedColor = this.initialColor;
  }

  changeColor(color:string){
    this.selectedColor = color;
  }
}
