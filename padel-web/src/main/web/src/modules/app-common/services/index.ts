import { AppCommonService } from './app-common.service';
import {InMemoryDataStore} from "@common/services/in-memory-data-store.service";

export const services = [AppCommonService,InMemoryDataStore];

export * from './app-common.service';
export * from './in-memory-data-store.service';
