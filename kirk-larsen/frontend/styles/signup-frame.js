import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-progress-bar/src/vaadin-progress-bar.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class SignupFrame extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-vertical-layout id="VerticalProcessBar" style="width: 100%; height: 45%; justify-content: flex-end;">
  <vaadin-vertical-layout style="width: 100%; height: 50%; align-self: center; justify-content: center; margin: var(--lumo-space-xl);">
   <label id="label" style="align-self: center; margin-top: var(--lumo-space-m);">Label</label>
   <vaadin-progress-bar id="progressBar" style="height: 50%; align-self: center; margin-top: var(--lumo-space-xl); width: 60%;"></vaadin-progress-bar>
  </vaadin-vertical-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout style="width: 100%; height: 100%;">
  <vaadin-vertical-layout id="content" style="width: 100%; height: 20%; margin-top: var(--lumo-space-xl); justify-content: center; align-items: center;"></vaadin-vertical-layout>
  <vaadin-vertical-layout style="width: 100%; height: 20%; align-self: center; align-items: center; margin-top: 10%; flex-direction: row; justify-content: center; padding: var(--lumo-space-xl);">
   <vaadin-button id="Back" theme="primary" style="margin: var(--lumo-space-xl);">
     Back 
   </vaadin-button>
   <vaadin-button id="Forward" theme="primary" style="margin: var(--lumo-space-xl);">
     Forward 
   </vaadin-button>
  </vaadin-vertical-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'signup-frame';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(SignupFrame.is, SignupFrame);
