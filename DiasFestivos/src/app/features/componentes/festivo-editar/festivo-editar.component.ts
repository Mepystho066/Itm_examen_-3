import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ReferenciasMaterialModule } from '../../../shared/modulos/referencias-material.module';
import { Festivo } from '../../../core/entidades/Festivo';
import { FormsModule } from '@angular/forms';

export interface DatosEdicionFestivo{
  encabezado: string ;
  /// Pude generar error si este esta similar a la Tabla Festivo
  festivo: Festivo;
}

@Component({
  selector: 'app-festivo-editar',
  standalone: true,
  imports: [
    ReferenciasMaterialModule,
    FormsModule
    
  ],
  templateUrl: './festivo-editar.component.html',
  styleUrl: './festivo-editar.component.css'
})
export class FestivoEditarComponent {
  /// De esta forma hacemos un cuadro de dialogo utilizando : MatDialogRef  y seleccionando el componente 
  constructor( public dialogRef: MatDialogRef<FestivoEditarComponent> ,
    @Inject(MAT_DIALOG_DATA) public datos : DatosEdicionFestivo  /// Para que reciba los datos 
  ){
    
  }


public cancelar(){
  this.dialogRef.close();
}

}
