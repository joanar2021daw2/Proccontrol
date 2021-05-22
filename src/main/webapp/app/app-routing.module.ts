import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PassosFormComponent } from './passos-form/passos-form.component';
import { PassosListComponent } from './passos-list/passos-list.component';
import { PrivacitatComponent } from './privacitat/privacitat.component';
import { PlayPasComponent } from './play-pas/play-pas.component';
import { PlayProcesComponent } from './play-proces/play-proces.component';
import { ProcesDetailsComponent } from './proces-details/proces-details.component';
import { ProcesFormComponent } from './proces-form/proces-form.component';
import { ProcesListComponent } from './proces-list/proces-list.component';
import { UpdateProcesComponent } from './update-proces/update-proces.component';
import { AppComponent } from './app.component';
import { UserLayoutComponent } from './user-layout/user-layout.component';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { ProcesCompletatComponent } from './proces-completat/proces-completat.component';

const routes: Routes = [
  { path: '', redirectTo: 'proces', pathMatch: 'full' },
  {
    path: '', component: AdminLayoutComponent,
    children: [
      { path: 'proces', component: ProcesListComponent },
      { path: 'passos', component: PassosListComponent },
      { path: 'newproces', component: ProcesFormComponent },
      { path: 'update-proces/:idProces', component: UpdateProcesComponent },
      { path: 'proces-details/:idProces', component: ProcesDetailsComponent },
      { path: 'passos-form', component: PassosFormComponent },
    ]
  },
  {
    path: '', component: UserLayoutComponent,
    children: [
      { path: 'privacitat', component: PrivacitatComponent },
      { path: 'play-proces/:idProces/:idUsuari', component: PlayProcesComponent },
      { path: 'play-pas', component: PlayPasComponent },
      { path: 'proces-completat', component: ProcesCompletatComponent }
    ]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
