import { Component } from '@angular/core';
import { ReferenciasMaterialModule } from '../../../shared/modulos/referencias-material.module';
import { FormsModule } from '@angular/forms';
import { ColumnMode, NgxDatatableModule, SelectionType } from '@swimlane/ngx-datatable';
import {Festivo} from '../../../core/entidades/Festivo'
import { formatDate } from '@angular/common';
import { FestivosService } from '../../servicios/festivos.service';
import { Tipo } from '../../../core/entidades/Tipo';
import { MatDialog } from '@angular/material/dialog';
import { FestivoEditarComponent } from '../festivo-editar/festivo-editar.component';
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
  public fechasPicker = new Date ; 
  public fechasPicker:   Date | undefined ; 
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
  // servicio para cuadros de dialogo : MatDialog ,  para poder cargar el cuadro de  dialog desde buscar
  constructor(private servicio: FestivosService , private servicioDialogo: MatDialog ){
    this.listar()
  }

  public listar(){ // al ser un observable se tiene que sucribir 
     this.servicio.listar().subscribe({
      next: response =>{
        this.festivos= response;
      },
      error: error =>{
        window.alert(error.mensage)
      }

     });
  }

public logica(){
  this.servicio.logica().subscribe({
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
    window.alert(`Dia festivo ${this.fechasPicker}}`)
  }


  public agregar(){
    // Aqui se muestar el cuadro de dialogo 
    this.servicioDialogo.open(FestivoEditarComponent,{
      //parametros
      width: "400px",
      height : "300px",
      disableClose: true,
      // para enviar datos con esa estructura 
      data : {
        encabezado : "Agregar festivo",
        festivo :{
          id:0,
          nombre:"",
          dia:0,
          mes:0,
        }
      }
    });
  
  }
  public modificar(){

  }
  public obtener(){
    
  }



}
