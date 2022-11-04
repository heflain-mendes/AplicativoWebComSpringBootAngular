import { UserFormComponent } from './model/user-form/user-form.component';
import { UserListComponent } from './model/user-list/user-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{
  path: "user",
  component: UserListComponent
},{
  path: "addUser",
  component: UserFormComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
