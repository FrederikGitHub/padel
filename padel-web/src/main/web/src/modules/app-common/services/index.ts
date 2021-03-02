import { AppCommonService } from './app-common.service';
import {InMemoryDataStore} from "@common/services/in-memory-data-store.service";
import {RouteData} from "@common/services/route-data.service";

export const services = [AppCommonService,InMemoryDataStore,RouteData];

export * from './app-common.service';
export * from './in-memory-data-store.service';
