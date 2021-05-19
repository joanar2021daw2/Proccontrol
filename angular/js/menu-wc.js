'use strict';


customElements.define('compodoc-menu', class extends HTMLElement {
    constructor() {
        super();
        this.isNormalMode = this.getAttribute('mode') === 'normal';
    }

    connectedCallback() {
        this.render(this.isNormalMode);
    }

    render(isNormalMode) {
        let tp = lithtml.html(`
        <nav>
            <ul class="list">
                <li class="title">
                    <a href="index.html" data-type="index-link">proccontrol documentation</a>
                </li>

                <li class="divider"></li>
                ${ isNormalMode ? `<div id="book-search-input" role="search"><input type="text" placeholder="Type to search"></div>` : '' }
                <li class="chapter">
                    <a data-type="chapter-link" href="index.html"><span class="icon ion-ios-home"></span>Getting started</a>
                    <ul class="links">
                        <li class="link">
                            <a href="overview.html" data-type="chapter-link">
                                <span class="icon ion-ios-keypad"></span>Overview
                            </a>
                        </li>
                        <li class="link">
                            <a href="index.html" data-type="chapter-link">
                                <span class="icon ion-ios-paper"></span>README
                            </a>
                        </li>
                                <li class="link">
                                    <a href="dependencies.html" data-type="chapter-link">
                                        <span class="icon ion-ios-list"></span>Dependencies
                                    </a>
                                </li>
                    </ul>
                </li>
                    <li class="chapter modules">
                        <a data-type="chapter-link" href="modules.html">
                            <div class="menu-toggler linked" data-toggle="collapse" ${ isNormalMode ?
                                'data-target="#modules-links"' : 'data-target="#xs-modules-links"' }>
                                <span class="icon ion-ios-archive"></span>
                                <span class="link-name">Modules</span>
                                <span class="icon ion-ios-arrow-down"></span>
                            </div>
                        </a>
                        <ul class="links collapse " ${ isNormalMode ? 'id="modules-links"' : 'id="xs-modules-links"' }>
                            <li class="link">
                                <a href="modules/AppModule.html" data-type="entity-link">AppModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-AppModule-36ef617511aefcc292a2c0a04d3349f4"' : 'data-target="#xs-components-links-module-AppModule-36ef617511aefcc292a2c0a04d3349f4"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-AppModule-36ef617511aefcc292a2c0a04d3349f4"' :
                                            'id="xs-components-links-module-AppModule-36ef617511aefcc292a2c0a04d3349f4"' }>
                                            <li class="link">
                                                <a href="components/AppComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">AppComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/PassosFormComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">PassosFormComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/PassosListComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">PassosListComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/PlayPasComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">PlayPasComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/PlayProcesComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">PlayProcesComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/PrivacitatComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">PrivacitatComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ProcesDetailsComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ProcesDetailsComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ProcesFormComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ProcesFormComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ProcesListComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ProcesListComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/UpdateProcesComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">UpdateProcesComponent</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/AppRoutingModule.html" data-type="entity-link">AppRoutingModule</a>
                            </li>
                </ul>
                </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#classes-links"' :
                            'data-target="#xs-classes-links"' }>
                            <span class="icon ion-ios-paper"></span>
                            <span>Classes</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? 'id="classes-links"' : 'id="xs-classes-links"' }>
                            <li class="link">
                                <a href="classes/Pas.html" data-type="entity-link">Pas</a>
                            </li>
                            <li class="link">
                                <a href="classes/Proces.html" data-type="entity-link">Proces</a>
                            </li>
                            <li class="link">
                                <a href="classes/Referencia.html" data-type="entity-link">Referencia</a>
                            </li>
                            <li class="link">
                                <a href="classes/Resultat.html" data-type="entity-link">Resultat</a>
                            </li>
                            <li class="link">
                                <a href="classes/Usuari.html" data-type="entity-link">Usuari</a>
                            </li>
                        </ul>
                    </li>
                        <li class="chapter">
                            <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#injectables-links"' :
                                'data-target="#xs-injectables-links"' }>
                                <span class="icon ion-md-arrow-round-down"></span>
                                <span>Injectables</span>
                                <span class="icon ion-ios-arrow-down"></span>
                            </div>
                            <ul class="links collapse " ${ isNormalMode ? 'id="injectables-links"' : 'id="xs-injectables-links"' }>
                                <li class="link">
                                    <a href="injectables/ProcesService.html" data-type="entity-link">ProcesService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/ReferenciaService.html" data-type="entity-link">ReferenciaService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/ResultatService.html" data-type="entity-link">ResultatService</a>
                                </li>
                            </ul>
                        </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#miscellaneous-links"'
                            : 'data-target="#xs-miscellaneous-links"' }>
                            <span class="icon ion-ios-cube"></span>
                            <span>Miscellaneous</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? 'id="miscellaneous-links"' : 'id="xs-miscellaneous-links"' }>
                            <li class="link">
                                <a href="miscellaneous/variables.html" data-type="entity-link">Variables</a>
                            </li>
                        </ul>
                    </li>
                        <li class="chapter">
                            <a data-type="chapter-link" href="routes.html"><span class="icon ion-ios-git-branch"></span>Routes</a>
                        </li>
                    <li class="chapter">
                        <a data-type="chapter-link" href="coverage.html"><span class="icon ion-ios-stats"></span>Documentation coverage</a>
                    </li>
                    <li class="divider"></li>
                    <li class="copyright">
                        Documentation generated using <a href="https://compodoc.app/" target="_blank">
                            <img data-src="images/compodoc-vectorise.png" class="img-responsive" data-type="compodoc-logo">
                        </a>
                    </li>
            </ul>
        </nav>
        `);
        this.innerHTML = tp.strings;
    }
});