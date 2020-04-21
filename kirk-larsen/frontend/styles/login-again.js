import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class LoginAgain extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); align-self: center; align-items: center; justify-content: center; height: auto; min-height: 10%;" id="Header"></vaadin-horizontal-layout>
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: center; align-items: center; justify-content: center;" id="Center">
  <vaadin-horizontal-layout style="flex-grow: 0; flex-shrink: 0; align-self: center; height: 30%; align-items: flex-end; justify-content: center;">
   <vaadin-form-layout style="align-self: center;">
    <vaadin-form-item id="username">
     <label slot="label">Username</label>
     <vaadin-text-field class="full-width" value="Jane" required></vaadin-text-field>
    </vaadin-form-item>
    <vaadin-form-item id="firstname">
     <label slot="label">First Name</label>
     <vaadin-text-field class="full-width" value="Jane"></vaadin-text-field>
    </vaadin-form-item>
    <vaadin-form-item id="lastname">
     <label slot="label">Last Name</label>
     <vaadin-text-field class="full-width" value="Doe"></vaadin-text-field>
    </vaadin-form-item>
    <vaadin-form-item id="email">
     <label slot="label">Email</label>
     <vaadin-text-field class="full-width" value="jane.doe@example.com"></vaadin-text-field>
    </vaadin-form-item>
    <vaadin-form-item id="adress">
     <label slot="label">Address</label>
     <vaadin-text-field class="full-width" value="Some Street 123"></vaadin-text-field>
    </vaadin-form-item>
    <vaadin-form-item id="submit">
     <vaadin-button theme="primary">
       Submit 
     </vaadin-button>
    </vaadin-form-item>
   </vaadin-form-layout>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="align-self: stretch; height: 70%;">
   <vaadin-password-field label="Password" placeholder="Enter password" value="secret1" id="password" has-value></vaadin-password-field>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);" id="Footer"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`
    }

    static get is() {
        return 'login-again';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(LoginAgain.is, LoginAgain);
