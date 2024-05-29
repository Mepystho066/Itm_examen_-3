import { Component } from '@angular/core';
import { ReferenciasMaterialModule } from '../../../shared/modulos/referencias-material.module';
import { FormsModule } from '@angular/forms';
import { ColumnMode, NgxDatatableModule, SelectionType } from '@swimlane/ngx-datatable';
import {Festivo} from '../../../core/entidades/Festivo'
import { formatDate } from '@angular/common';
import { FestivosService } from '../../servicios/festivos.service';
import { Tipo } from '../../../core/entidades/Tipo';
@Component({
  selector: 'app-tabla-festivos',
  standalone: true,
  imports: [
    ReferenciasMaterialModule,
    FormsModule, // para entrada de datos 
    NgxDatatableModule,
  ],
  templateUrl: './tabla-festivos.component.html',
  styleUrl: './tabla-festivos.component.css'
})
export class TablaFestivosComponent {
  /* problemas para que no se muestre la fecha 
  public fechasPicker:   Date | undefined ; 
  public fechasPicker = new Date ; 
  */
  public fechasPicker: string = "";
  public festivos: Festivo [] =[];
  public tiposFestivo: Tipo [] = [];
  public modoColumnas =  ColumnMode;
  public tipoFestivo = SelectionType;


  public columnas :any[] = [
    {name:"Festivo", prop:"nombre"},
    {name:"Tipo", prop:"dia" }
  ]

  constructor(private servicio: FestivosService){
    this.listar()
  }

  public listar(){
     this.servicio.listar().subscribe({
      next: response =>{
        this.festivos= response;
      },
      error: error =>{
        window.alert(error.mensage)
      }

     });
  }

  public verificar(){
    const fechas = new Date(this.fechasPicker);
    const dia= fechas?.getDate() ;
    const mes= fechas?.getMonth() +1;
    const año= fechas?.getFullYear() ;
    console.log(dia )
    console.log(`Dia : ${dia} Mes: ${mes}  Año: ${año}`);
  }
  public agregar(){

  }
  public modificar(){

  }
  public verificarEliminar(){
    
  }



}
