import axios from 'axios'
import {getBaseUrl} from './apiEndPoints'

const apiBaseUrl = getBaseUrl();  // API Base Url

/**
 * Create Axios instance with default HTTP Settings
 */
const instance = axios.create({
  baseURL: `${apiBaseUrl}`,
  timeout: 30000,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json',
  },
});

export default instance;
