import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-login/src/vaadin-login-form.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

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
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 1; align-self: center; align-items: stretch; justify-content: center; height: 100%; background-color: var(--lumo-contrast-10pct); min-height: auto; flex-grow: 1;" id="Header" theme="spacing"></vaadin-horizontal-layout>
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; align-self: center; align-items: center; justify-content: center; height: 100%; max-height: 85%; min-height: auto; flex-direction: column;" id="Center">
  <vaadin-login-form id="loginForm"></vaadin-login-form>
 </vaadin-vertical-layout>
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
