import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PersonaComponent } from './components/persona/persona.component';
import { PersonaFormComponent } from './components/persona/persona-form.component';
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

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'login'},
  {path: 'personas', component: PersonaComponent},
  {path: 'personas/form', component: PersonaFormComponent},
  {path: 'personas/form/:id', component: PersonaFormComponent},

  {path: 'roles', component: RoleComponent},
  {path: 'roles/form', component: RoleFormComponent},
  {path: 'roles/form/:id', component: RoleFormComponent},

  {path: 'usuarios', component: UsuarioComponent},
  {path: 'usuarios/form', component: UsuarioFormComponent},
  {path: 'usuarios/form/:id', component: UsuarioFormComponent},
  {path: 'usuarios/csv', component: UsuarioCSVComponent},

  {path: 'rol-opciones', component: RolOpcionesComponent},
  {path: 'rol-opciones/form', component: RolOpcionesFormComponent},
  {path: 'rol-opciones/form/:id', component: RolOpcionesFormComponent},

  {path: 'sessions', component: SessionComponent},
  {path: 'sessions/form', component: SessionFormComponent},
  {path: 'sessions/form/:id', component: SessionFormComponent},

  {path: 'login', component: LoginComponent},
  {path: 'forbidden', component: Forbidden403Component},

  {path: 'mantenimiento-usuarios', component: MantenimientoUsuariosComponent},
  {path: 'bienvenida', component: BienvenidaComponent},
  {path: 'dashboard', component: DashboardComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
