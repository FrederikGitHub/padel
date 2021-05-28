/* tslint:disable: ordered-imports*/
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

/* Third Party */
import {NgbDateParserFormatter, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { IconsModule } from '@modules/icons/icons.module';

const thirdParty = [IconsModule, NgbModule];

/* Containers */
import * as appCommonContainers from './containers';

/* Components */
import * as appCommonComponents from './components';

/* Guards */
import * as appCommonGuards from './guards';

import * as appCommonPipes from './pipes';


/* Services */
import * as appCommonServices from './services';
import * as authServices from '@modules/auth/services';
import {CallbackPipe} from "./pipes";
import {NgbDateCustomParserFormatter} from "@common/services/custom-date-formatter-parser.service";
import {EffectsModule} from "@ngrx/effects";
import {CommonEffects} from "@common/effects/common.effects";

@NgModule({
    imports: [CommonModule,NgbModule, RouterModule, ...thirdParty,EffectsModule.forFeature([CommonEffects])],
    providers: [{provide: NgbDateParserFormatter, useClass: NgbDateCustomParserFormatter},...appCommonServices.services, ...authServices.services, ...appCommonGuards.guards,...appCommonPipes.pipes],
    declarations: [...appCommonContainers.containers, ...appCommonComponents.components, CallbackPipe],
    exports: [...appCommonContainers.containers, ...appCommonComponents.components, ...thirdParty, CallbackPipe],
})
export class AppCommonModule {}
