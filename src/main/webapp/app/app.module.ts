import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProcesFormComponent } from './proces-form/proces-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { PassosListComponent } from './passos-list/passos-list.component';
import { ProcesListComponent } from './proces-list/proces-list.component';
import { UpdateProcesComponent } from './update-proces/update-proces.component';
import { ProcesDetailsComponent } from './proces-details/proces-details.component';
import { PassosFormComponent } from './passos-form/passos-form.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PrivacitatComponent } from './privacitat/privacitat.component';

@NgModule({
  declarations: [
    AppComponent,
    ProcesFormComponent,
    PassosListComponent,
    ProcesListComponent,
    UpdateProcesComponent,
    ProcesDetailsComponent,
    PassosFormComponent,
    PrivacitatComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ConfirmationPopoverModule.forRoot({
      confirmButtonType: 'danger'
    }),
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
