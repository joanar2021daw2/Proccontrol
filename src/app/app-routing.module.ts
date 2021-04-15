import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProcesFormComponent } from './proces-form/proces-form.component';

const routes: Routes = [
  {path: 'newproces', component: ProcesFormComponent },
  {path: '', redirectTo: 'newproces', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
