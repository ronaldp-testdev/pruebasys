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
import { authGuard } from './guards/auth.guard';
import { OpcionesAvanzadasComponent } from './components/opciones-avanzadas/opciones-avanzadas.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'login'},
  {path: 'personas', component: PersonaComponent, canActivate:[authGuard]},
  {path: 'personas/form', component: PersonaFormComponent,canActivate:[authGuard]},
  {path: 'personas/form/:id', component: PersonaFormComponent, canActivate:[authGuard]},

  {path: 'roles', component: RoleComponent,canActivate:[authGuard] },
  {path: 'roles/form', component: RoleFormComponent, canActivate:[authGuard]},
  {path: 'roles/form/:id', component: RoleFormComponent, canActivate:[authGuard]},

  {path: 'usuarios', component: UsuarioComponent, canActivate:[authGuard]},
  {path: 'usuarios/form', component: UsuarioFormComponent, canActivate:[authGuard]},
  {path: 'usuarios/form/:id', component: UsuarioFormComponent, canActivate:[authGuard]},
  {path: 'usuarios/csv', component: UsuarioCSVComponent, canActivate:[authGuard]},

  {path: 'rol-opciones', component: RolOpcionesComponent, canActivate:[authGuard]},
  {path: 'rol-opciones/form', component: RolOpcionesFormComponent, canActivate:[authGuard]},
  {path: 'rol-opciones/form/:id', component: RolOpcionesFormComponent, canActivate:[authGuard]},

  {path: 'sessions', component: SessionComponent, canActivate:[authGuard]},
  {path: 'sessions/form', component: SessionFormComponent, canActivate:[authGuard]},
  {path: 'sessions/form/:id', component: SessionFormComponent, canActivate:[authGuard]},

  {path: 'login', component: LoginComponent},
  {path: 'forbidden', component: Forbidden403Component},

  {path: 'mantenimiento-usuarios', component: MantenimientoUsuariosComponent, canActivate:[authGuard]},
  {path: 'bienvenida', component: BienvenidaComponent},
  {path: 'dashboard', component: DashboardComponent, canActivate:[authGuard]},
  {path: 'opciones-avanzadas', component: OpcionesAvanzadasComponent, canActivate:[authGuard]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
