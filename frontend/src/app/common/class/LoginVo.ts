/**
 * Created by zhaowei on 2017/10/17.
 */
export class LoginVo {
  loginName: string;
  password: string;
  constructor(loginName: string, password: string) {
    this.loginName = loginName;
    this.password = password;
  }
}
