import request from '@/utils/request';
import { stringify } from 'qs';

export async function queryResource(params) {
  const queryParams = params ? `?${stringify(params)}` : '';
  return request(`/haoke/house/resources${queryParams}`);
}
