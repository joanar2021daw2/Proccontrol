import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PassosListComponent } from './passos-list/passos-list.component';
import { ProcesFormComponent } from './proces-form/proces-form.component';
import { ProcesListComponent } from './proces-list/proces-list.component';
import { UpdateProcesComponent } from './update-proces/update-proces.component';

const routes: Routes = [
  {path: 'proces', component: ProcesListComponent },
  {path: '', redirectTo: 'proces', pathMatch: 'full'},
  {path: 'passos', component: PassosListComponent},
  {path: 'newproces', component: ProcesFormComponent},
  {path: 'update-proces/:idProces', component: UpdateProcesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
