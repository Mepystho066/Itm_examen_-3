import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ReferenciasMaterialModule } from './shared/modulos/referencias-material.module'; /// Referencias al modulo de Matirial Archivo del profesor
import { TablaFestivosComponent } from './features/componentes/tabla-festivos/tabla-festivos.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,
    ReferenciasMaterialModule,
    TablaFestivosComponent
  ],  
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'DiasFestivos';
}


