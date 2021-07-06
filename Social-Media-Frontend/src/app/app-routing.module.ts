import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {HomePageComponent} from './components/home-page/home-page.component';
import {NewsFeedsComponent} from './components/news-feeds/news-feeds.component';
import {MyProfileComponent} from './components/my-profile/my-profile.component';
import {LoginComponent} from './components/login/login.component';
import {SignupComponent} from './components/signup/signup.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'sign-up', component: SignupComponent},
  {path: '', component: HomeComponent, children: [
      {path: 'home-page', component: HomePageComponent},
      {path: 'news-feed', component: NewsFeedsComponent},
      {path: 'my-profile', component: MyProfileComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
