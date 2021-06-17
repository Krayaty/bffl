import { AppPage } from './app.po';
import {browser, By} from 'protractor';

describe('BFFL application create section', () => {
  let page: AppPage;

  beforeEach(async () => {
    page = new AppPage();
  });

  it('should redirect to the login', async () => {
    await browser.waitForAngularEnabled(false);
    await page.navigateTo();
    await browser.sleep(750);

    expect(browser.getCurrentUrl()).toContain('auth.bfflshort.de');
  });

  it('should login', async () => {
    // make sure to enter credentials when running the tests locally
    const user = '';
    const pw = '';

    await browser.findElement(By.css('#username')).sendKeys(user);
    await browser.findElement(By.css('#password')).sendKeys(pw);
    await browser.element(By.id('kc-form-login')).submit();
    await browser.sleep(500);

    await expect(browser.findElements(By.css('.login-pf-header')).then(elements => {
      return elements.length;
    })).toBe(0);
  });

  it('should select the first group', async () => {
    await browser.sleep(500);
    await browser.findElements(By.css('.ag-cell')).then(groups => {
      groups[0].click();
    });
    await browser.sleep(1000);

    await expect(browser.findElement(By.css('app-topbar'))
      .then(result => {
        return result;
    })).toBeTruthy();
  });

  it('should fail to shorten without a scope', async () => {
    await browser.findElement(By.cssContainingText('a', 'Shorten URL')).click();
    await browser.sleep(500);
    await browser.findElement(By.cssContainingText('label',
      'Should the ShortURL be deletable?')).click();

    await enterUrl();
    await enterSuffix();
    await browser.findElement(By.id('submit')).click();
    await browser.sleep(500);

    await expect(browser.switchTo().alert().getText()).toEqual('Missing or wrong argument for scope');
    await browser.switchTo().alert().accept();
  });

  xit('should fail to shorten without a link', async () => {
    await browser.findElement(By.id('targetURL')).clear().then(result => {
      browser.sleep(1000);
      browser.findElement(By.id('targetURL')).sendKeys('a');
    });
    await enterSuffix();
    await setScope();
    await browser.findElement(By.id('submit')).click();
    await browser.sleep(500);

    await expect(browser.switchTo().alert().getText()).toEqual('Missing or wrong argument for TargetURL');
    await browser.switchTo().alert().accept();
    await expect(browser.findElement(By.cssContainingText('div',
      'URL is required.')).then(result => {
      return result;
    })).toBeTruthy();
  });

  xit('should fail to shorten without a suffix', async () => {
    await enterUrl();
    await setScope();
    await browser.findElement(By.id('customSuffix')).clear().then(null);
    await browser.sleep(10000);
    await browser.findElement(By.cssContainingText('label',
      'Which suffix do you want for your ShortURL')).click();

    await expect(browser.switchTo().alert().getText()).toEqual('Missing or wrong argument for suffix of ShortURL');
    await browser.switchTo().alert().accept();
    await expect(browser.findElements(By.cssContainingText('div',
      'Custom Suffix is required.')).then(result => {
      return result;
    })).toBeTruthy();
  });

  xit('should shorten a link', async () => {
    await enterSuffix();

    await expect(browser.findElements(By.cssContainingText('span', 'Assigned On')).then(results => {
      return results.length;
    })).toBe(1);
    await browser.sleep(100000);
  });
});

async function enterUrl(): Promise<void> {
  const element = await browser.findElement(By.id('targetURL'));
  await element.clear().then(result => {
    element.sendKeys('https://google.de');
  });
}

async function enterSuffix(): Promise<void> {
  const element = await browser.findElement(By.id('customSuffix'));
  await element.clear().then(result => {
    element.sendKeys('e2eTest');
  });
}

async function setScope(): Promise<void> {
  await browser.findElement(By.cssContainingText('option', 'Forever')).click();
}
