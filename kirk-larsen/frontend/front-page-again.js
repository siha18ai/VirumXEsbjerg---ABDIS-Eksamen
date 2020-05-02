import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

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
 <vaadin-horizontal-layout id="Header" style="width: 100%; flex-grow: 1; flex-shrink: 1; background-color: height: 17.5%; background-color: var(--lumo-contrast-10pct); align-self: center; align-items: stretch; min-height: auto; flex-grow: 1; min-width: 100%; flex-direction: column; justify-content: center;" class="header"></vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="align-self: center; align-items: center; justify-content: space-between; width: 100%; height: 84%; flex-direction: column;" id="Center">
  <vaadin-horizontal-layout id="ProgressAndLabel" style="width: 100%; align-self: center; height: 20%; align-items: center; justify-content: center; flex-direction: column;"></vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="width: 100%; height: 80%; align-self: center; align-items: center; justify-content: center; flex-direction: column;">
   <vaadin-vertical-layout id="Center1" style="width: 100%; height: 70%; align-items: center; justify-content: center; align-self: center;"></vaadin-vertical-layout>
   <vaadin-horizontal-layout id="footer" style="width: 100%; height: 20%; align-items: center; justify-content: center;"></vaadin-horizontal-layout>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
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
