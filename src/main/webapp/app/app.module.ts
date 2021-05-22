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
import { PlayProcesComponent } from './play-proces/play-proces.component';
import { PlayPasComponent } from './play-pas/play-pas.component';
import { UserLayoutComponent } from './user-layout/user-layout.component';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { ProcesCompletatComponent } from './proces-completat/proces-completat.component';

@NgModule({
  declarations: [
    AppComponent,
    ProcesFormComponent,
    PassosListComponent,
    ProcesListComponent,
    UpdateProcesComponent,
    ProcesDetailsComponent,
    PassosFormComponent,
    PrivacitatComponent,
    PlayProcesComponent,
    PlayPasComponent,
    UserLayoutComponent,
    AdminLayoutComponent,
    ProcesCompletatComponent,
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
