import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatInputModule} from '@angular/material/input';
import { PersonaComponent } from './components/persona/persona.component';
import { HttpClientModule, provideHttpClient, withInterceptors } from '@angular/common/http';
import { MatFormFieldModule } from '@angular/material/form-field';
import { PersonaFormComponent } from './components/persona/persona-form.component';
import { FormsModule } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { provideNativeDateAdapter } from '@angular/material/core';
import { RoleComponent } from './components/role/role.component';
import { RoleFormComponent } from './components/role/role-form.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { UsuarioFormComponent } from './components/usuario/usuario-form.component';
import { RolOpcionesComponent } from './components/rol-opciones/rol-opciones.component';
import { RolOpcionesFormComponent } from './components/rol-opciones/rol-opciones-form.component';
import { SessionComponent } from './components/session/session.component';
import { SessionFormComponent } from './components/session/session-form.component';
import { LoginComponent } from './components/login/login.component';
import { Forbidden403Component } from './components/forbidden403/forbidden403.component';
import { MantenimientoUsuariosComponent } from './components/mantenimiento-usuarios/mantenimiento-usuarios.component';
import { BienvenidaComponent } from './components/bienvenida/bienvenida.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { UsuarioCSVComponent } from './components/usuario/usuario-csv.component';
import { tokenInterceptorInterceptor } from './interceptors/token-interceptor.interceptor';


@NgModule({
  declarations: [
    AppComponent,
    PersonaComponent,
    PersonaFormComponent,
    RoleComponent,
    RoleFormComponent,
    UsuarioComponent,
    UsuarioFormComponent,
    RolOpcionesComponent,
    RolOpcionesFormComponent,
    SessionComponent,
    SessionFormComponent,
    LoginComponent,
    Forbidden403Component,
    MantenimientoUsuariosComponent,
    BienvenidaComponent,
    DashboardComponent,
    UsuarioCSVComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
  ],
  providers: [
    DatePipe,
    provideAnimationsAsync(),
    provideNativeDateAdapter(),
    provideHttpClient(withInterceptors([tokenInterceptorInterceptor])),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
