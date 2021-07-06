import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './components/home/home.component';
import {RouterModule} from '@angular/router';
import {FlashMessagesModule} from 'angular2-flash-messages';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import { HomePageComponent } from './components/home-page/home-page.component';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NewsFeedsComponent } from './components/news-feeds/news-feeds.component';
import { MyProfileComponent } from './components/my-profile/my-profile.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import {NewsFeedsService} from './services/news-feeds.service';
import {AuthService} from './services/auth.service';
import {LocationsService} from './services/locations.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HomePageComponent,
    NewsFeedsComponent,
    MyProfileComponent,
    LoginComponent,
    SignupComponent,
  ],
  imports: [
    NgxPaginationModule,
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    FlashMessagesModule.forRoot(),
    ReactiveFormsModule,
    BsDropdownModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [
    NewsFeedsService,
    AuthService,
    LocationsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
