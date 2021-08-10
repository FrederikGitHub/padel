/* tslint:disable: ordered-imports*/
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';

/* Third Party */
import {IconsModule} from '@modules/icons/icons.module';
/* Containers */
import * as appCommonContainers from './containers';

/* Components */
import * as appCommonComponents from './components';

/* Guards */
import * as appCommonGuards from './guards';

import * as appCommonPipes from './pipes';
import {CallbackPipe} from './pipes';


/* Services */
import * as appCommonServices from './services';
import * as authServices from '@modules/auth/services';
import {EffectsModule} from "@ngrx/effects";
import {CommonEffects} from "@common/effects/common.effects";

const thirdParty = [IconsModule];


@NgModule({
    imports: [CommonModule,RouterModule, ...thirdParty,EffectsModule.forFeature([CommonEffects])],
    providers: [...appCommonServices.services, ...authServices.services, ...appCommonGuards.guards,...appCommonPipes.pipes],
    declarations: [...appCommonContainers.containers, ...appCommonComponents.components, CallbackPipe],
    exports: [...appCommonContainers.containers, ...appCommonComponents.components, ...thirdParty, CallbackPipe],
})
export class AppCommonModule {}
