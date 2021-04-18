import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProcesFormComponent } from './proces-form/proces-form.component';
import { FormsModule } from '@angular/forms';
import { PassosListComponent } from './passos-list/passos-list.component';
import { ProcesListComponent } from './proces-list/proces-list.component';
import { UpdateProcesComponent } from './update-proces/update-proces.component';

@NgModule({
  declarations: [
    AppComponent,
    ProcesFormComponent,
    PassosListComponent,
    ProcesListComponent,
    UpdateProcesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
