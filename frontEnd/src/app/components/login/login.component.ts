import { Component } from '@angular/core';
import Swal from 'sweetalert2';
import { User } from '../../models/user';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {
  user: User;

  constructor(private authService: AuthService, private router: Router){
    this.user = new User;
  }

  onSubmit() {
    if(!this.user.username || !this.user.password){
      Swal.fire(
        'Error de validación',
        'Username y Password requeridos',
        'error'
      );
    }else{
      //Enviar username y password para loguear
      this.authService.loginUser({ username: this.user.username, password: this.user.password}).subscribe({
        next:response => {
          const token = response.token;
          //Decodificar token
          const payload = this.authService.getPayload(token);
          const user = { username: payload.sub };
          const login = {
            user,
            isAuth: true,
            isAdmin: payload.isAdmin
          }
          console.log(login);

          this.authService.token = token;
          this.authService.user = login;
          
          console.log(payload);
          this.router.navigate(['/personas']);
        },
        error: error => {
          if(error.status == 401){
            console.log(error.error);
            Swal.fire('Error en el login', error.error.message ,'error')
          }else{
            throw error;
          }
        }
      })
    }
   }

}
