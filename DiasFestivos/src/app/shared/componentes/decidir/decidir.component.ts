import { Component, Inject } from '@angular/core';
import { ReferenciasMaterialModule } from '../../modulos/referencias-material.module';
import { FormsModule } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { DatosEdicionFestivo, FestivoEditarComponent } from '../../../features/componentes/festivo-editar/festivo-editar.component';

export interface EliminarDatos{
  encabezado:string;
  id:number;
}
@Component({
  selector: 'app-decidir',
  standalone: true,
  imports: [
    ReferenciasMaterialModule,
    FormsModule
    
  ],
  templateUrl: './decidir.component.html',
  styleUrl: './decidir.component.css'
})
export class DecidirComponent {

  constructor( public dialogRef:MatDialogRef<FestivoEditarComponent> , @Inject(MAT_DIALOG_DATA) public datos:DatosEdicionFestivo  ){

  }


  cancelar(){
    this.dialogRef.close();
  }
}
