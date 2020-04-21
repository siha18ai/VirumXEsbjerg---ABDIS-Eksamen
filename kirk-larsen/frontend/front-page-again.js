import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class FrontPageAgain extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout id="vaadinHorizontalLayout" style="width: 100%; flex-grow: 0; flex-shrink: 1; margin-bottom: 50; height: 20%; align-self: center; justify-content: center; align-items: center;" theme="spacing"></vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="align-self: center;">
  <vaadin-button theme="primary" id="login">
   Login
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout> ;
`
    }
    static get is() {
        return 'front-page-again';
    }

    static get properties() {
        return {
        };
    }
}

customElements.define(FrontPageAgain.is, FrontPageAgain);