import { AppPage } from './app.po';
import {browser, By, logging} from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should redirect to the login', () => {
    browser.waitForAngularEnabled(false);
    page.navigateTo();
    expect(browser.getCurrentUrl()).toContain('auth.bfflshort.de');
  });

  it('should login', async () => {
    // make sure to enter credentials when running the tests locally
    const user = '';
    const pw = '';
    browser.findElement(By.css('#username')).sendKeys(user);
    browser.findElement(By.css('#password')).sendKeys(pw);
    await browser.element(By.id('kc-form-login')).submit();

    expect(browser.findElements(By.css('app-root div'))).toBeTruthy();
  });
});
